@echo off
start /b cmd /c morinoko.bat
echo "waiting for 10 seconds.."
ping -n 10 127.0.0.1 >nul
curl http://localhost:9000/health