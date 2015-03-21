@echo off
title Shard Revolutions: Compile
echo ===== COMPILING - PLEASE WAIT... =====
"C:\Program Files\Java\jdk1.8.0_05\bin\javac.exe" -Xlint:none -d bin -cp src/*.java src/sign/*java
echo ===== DONE ===========================
pause
exit

