@echo off
REM ====================================================================
REM CONFIGURAÇÕES CENTRALIZADAS - MUDE APENAS AQUI!
REM ====================================================================
set EC2_USER=ec2-user
set EC2_IP=10.0.19.150
set EC2_PASSWORD=98520211
set JAR_NAME=barbearia-api-0.0.1-SNAPSHOT.jar
set SCREEN_NAME=host
set APP_PORT=8080
set PUBLIC_PORT=443
REM ====================================================================

echo.
echo 🚀 INICIANDO APLICAÇÃO BARBEARIA
echo.
echo ✓ IP Privado (fixo): %EC2_IP%
echo ✓ JAR: %JAR_NAME%
echo ✓ Screen: %SCREEN_NAME%
echo ✓ Porta: %PUBLIC_PORT% → %APP_PORT%
echo.

REM Criar comandos
echo 🔧 Preparando comandos...
(
echo sudo iptables -t nat -A PREROUTING -p tcp --dport %PUBLIC_PORT% -j REDIRECT --to-port %APP_PORT%
echo sudo pkill -f java
echo screen -S %SCREEN_NAME% -X quit 2^>/dev/null ^|^| true
echo screen -dmS %SCREEN_NAME% bash -c "java -jar %JAR_NAME%"
echo sleep 3
echo echo "=== STATUS ==="
echo pgrep -f java ^&^& echo "✅ Java rodando" ^|^| echo "❌ Java não rodando"
echo netstat -tlnp ^| grep :%APP_PORT% ^&^& echo "✅ Porta %APP_PORT% ativa" ^|^| echo "❌ Porta %APP_PORT% não ativa"
echo screen -list ^| grep %SCREEN_NAME% ^&^& echo "✅ Screen %SCREEN_NAME% ativo" ^|^| echo "❌ Screen %SCREEN_NAME% não ativo"
) > comandos.tmp

REM Executar comandos via SSH
echo 🔗 Conectando em %EC2_IP%...
echo yes | ssh -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null %EC2_USER%@%EC2_IP% < comandos.tmp

REM Limpar arquivo temporário
del comandos.tmp

echo.
echo ✅ Aplicação iniciada!
echo 🔗 Acesso via IP público (verifique no console AWS)
echo.
echo 📊 Para ver logs:
echo    ssh %EC2_USER%@%EC2_IP%
echo    screen -r %SCREEN_NAME%
echo.
pause

