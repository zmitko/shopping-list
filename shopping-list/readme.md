**REACT BUILD**

Search "localhost:5000" (1 hit in 1 file) shopping-list-client-feature-teacher-server\src\calls.js (1 hit) Line 26:         "http://localhost:5000/" + useCase


**DOCKER**

Pokud je pouzit Docker Toolbox, ktery vyuziva jiny sitovy rozsah, nez localhost, je potreba v reactu zmenit IP adresu na kterou se vola REST, jinak dojde ke CORS problemum mezi Dockerem a prohlizecem.

Alternativne lze vyuzit port forwarding vyuzivany Virtualboxem viz



I initially had a few issues with accessing my Applications at localhost:8080 while using DockerToolBox and OracleVM VirtualBox.

In VirtualBox:

    Click the appropriate machine (probably the one labeled "default")
    Settings
    Network > Adapter 1 > Advanced > Port Forwarding
    Click "+" to add a new Rule
    Set Host Port 8080 & Guest Port 8080; be sure to leave Host IP and Guest IP empty

Run the command:

`docker run -p 8080:8080 ${image_id}`

