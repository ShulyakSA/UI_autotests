cmd /C start/MIN java -jar selenium-server-4.15.0.jar hub --port 4444 --session-request-timeout 300
cmd /C start/MIN java -jar selenium-server-4.15.0.jar node --hub http://localhost:4444/grid/register --port 5555 --detect-drivers true  --selenium-manager true