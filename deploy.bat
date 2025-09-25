@echo off

REM Caminho absoluto até o projeto
cd /d "C:\Users\evito\dev\git\domina dev\projeto-barbearia-api"

echo Fazendo build do projeto...
call mvn clean install
if errorlevel 1 (
    echo Erro ao compilar o projeto.
    pause
    exit /b
)

echo Enviando JAR para EC2...
scp target\barbearia-api-0.0.1-SNAPSHOT.jar ec2-user@18.231.62.84:/home/ec2-user
if errorlevel 1 (
    echo Erro ao copiar o JAR.
    pause
    exit /b
)

echo Conectando na EC2 e iniciando aplicação...
ssh ec2-user@18.231.62.84 ^
"screen -dmS host bash -c 'java -jar /home/ec2-user/barbearia-api-0.0.1-SNAPSHOT.jar'"
echo Aplicação iniciada com sucesso!
pause
