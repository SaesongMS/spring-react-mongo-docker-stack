FROM mongo

COPY movies.json /movies.json
COPY roles.json /roles.json
COPY top_genres.json /top_genres.json
COPY users.json /users.json
COPY anime.json /anime.json
COPY top_genres_anime.json /top_genres_anime.json
COPY list.json /list.json

CMD mongoimport --uri mongodb://mongo:27018 --db db --collection users --type json --file /users.json --jsonArray && \
     mongoimport --uri mongodb://mongo:27018 --db db --collection roles --type json --file /roles.json --jsonArray && \
     mongoimport --uri mongodb://mongo:27018 --db db --collection movies --type json --file /movies.json --jsonArray && \
     mongoimport --uri mongodb://mongo:27018 --db db --collection top_genres --type json --file /top_genres.json --jsonArray && \
     mongoimport --uri mongodb://mongo:27018 --db db --collection anime --type json --file /anime.json --jsonArray && \
     mongoimport --uri mongodb://mongo:27018 --db db --collection top_genres_anime --type json --file /top_genres_anime.json --jsonArray && \
     mongoimport --uri mongodb://mongo:27018 --db db --collection list --type json --file /list.json --jsonArray