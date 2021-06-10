# Tech Stack
- Java 16
- SpringBoot 2.5
- Mongo database
- Docker




# Note
- this project provides just backend service, all other requirements ignored.


# Build & Run
- First you need to install dependencies by running clean and build gradle commands.
- Then to build and run the project on docker, you need to run following commands:
    - docker build -f Dockerfile -t readingisgood-img .
    - docker images (to see if image is build)
    - docker run -p 7676:7677 readingisgood-img
- Once you run the server you can access the project at port 7676.