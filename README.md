# movie-scheduler-kotlin <br />

Sample Kotlin based Spring boot application <br />

Steps to Run: <br />

git clone the repo <br />
run the mysql scripts from database package <br />
Run the bootrun task: "gradlew bootRun" <br />
Test the service endpoints using CURL or Postman <br />

curl -H "Content-Type: application/json" -X POST http://localhost:8080/movie-scheduler/proposeMovie -d "{\"movieGenre\": \"Action\", \"movieLanguage\": \"Tamil\", \"playTime\": \"2018-06-15 10:10:00.000\", \"movieName\": \"Dheena\"} <br />
curl -X GET http://localhost:8080/movie-scheduler/getMovies <br />
