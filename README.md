<div align="center">
  <h1>Movie review backend</h1>

![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

<p>Backend for a movie review application, where users can give scores and write reviews of movies they've watched.</p>

</div>

The API supports the following endpoints and actions

<div align="center">

| Method | URL pattern               | Action                                             |
|--------|---------------------------|----------------------------------------------------|
| POST   | api/v1/auth/register      | Register a new user                                |
| POST   | api/v1/auth/login         | Log in                                             |
| GET    | api/v1/users/me           | Get logged in user information and reviews         |
| PATCH  | api/v1/users/me           | Update logged in user information                  |
| GET    | api/v1/users/{username}   | Get user information and reviews                   |
| GET    | api/v1/movies             | Get all movies with their respective reviews       |
| GET    | api/v1/movies/{id}        | Get information and reviews for a particular movie |
| POST   | api/v1/movies             | Create a new movie (ADMIN only)                    |
| DELETE | api/v1/movies/{id}        | Delete a movie (ADMIN only)                        |
| PATCH  | api/v1/movies/{id}        | Update movie information (ADMIN only)              |
| POST   | api/v1/reviews/movie/{id} | Create a review for a movie                        |

</div>

## ⚙️ Setup

You'll need to have Docker installed. Just run:

```bash
$ docker compose up -d
```

for the database. Then, just run the project.

## 🎬 Examples

### Creating a user

Request

```bash
curl --request POST \
  --url http://localhost:8080/api/v1/auth/register \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: Insomnia/2023.5.7' \
  --cookie JSESSIONID=30FD64CA98B46417A8EACEA42976CB2C \
  --data '{
	"name": "Ryan Gosling",
	"email": "ryangosling@example.com",
	"username": "ryangosling",
	"password": "password"
}'
```

Response

```json
{
	"userId": 16,
	"name": "Ryan Gosling",
	"email": "ryangosling@example.com",
	"username": "ryangosling",
	"reviews": [],
	"enabled": true,
	"accountNonLocked": true,
	"credentialsNonExpired": true,
	"accountNonExpired": true
}
```

### Authenticating a user

Request 

```shell
curl --request POST \
  --url http://localhost:8080/api/v1/auth/login \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: Insomnia/2023.5.7' \
  --cookie JSESSIONID=30FD64CA98B46417A8EACEA42976CB2C \
  --data '{
	"username" : "ryangosling",
	"password" : "password"
}'
```

Response

```json
{
	"user": {
		"userId": 16,
		"name": "Ryan Gosling",
		"email": "ryangosling@example.com",
		"username": "ryangosling",
		"reviews": [],
		"enabled": true,
		"accountNonLocked": true,
		"credentialsNonExpired": true,
		"accountNonExpired": true
	},
	"jwt": "eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoicnlhbmdvc2xpbmciLCJpYXQiOjE2OTQxMDgwODQsInJvbGVzIjoiVVNFUiJ9.OXZb_aIcunRuU6Wd47Dr6L3gz13ic1XPFg8WtiyDbHvKlUYe_OjmL8IrJP0fZIioqchQAfTIJOgWFvsXgGc9nLr_L2LYPfV9XbGCHaWaFCmiHeK1DsqRJex2ZJyFvvWz-NmcU3HO0uklJBwMOMgRDtnuZwWVEOgCNncPFVi70sOSOUi7CeciLvfXLL5aYQ2JUFn2Uf_UjCo9YGZnTGvpGCNd0cAiJUzPAbIxoAnOgF0OaTBf3UrtjAP_7E1wUcj3sc5xOF-7gkL1_0kXMjkJ9ZqPiA5DC1Awq-aFVWdAQCTFzpd-cTgmdUtfZ9CbpDY9PTG6fZqr2wP-iwDpEIsHcA"
}
```

### Creating a movie

Request

```shell
curl --request POST \
  --url http://localhost:8080/api/v1/movies \
  --header 'Authorization: Bearer eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoiYWRtaW4iLCJpYXQiOjE2OTQxMDc2MjcsInJvbGVzIjoiQURNSU4ifQ.jdwhBX6qQUxD2sI7WeX0iG3lVxOAU2s8ZmCPalsP4pen0DrIpWTj8Zso64qrHh-xygraf-55KWUjkk_KNyvbMNqwaMwSXiQ9uvrkIDHkgc1xaI8Ejuj9_gEt3e6Fc777qNPAfY6uA8Cuo7ymfOiCiAuNq1RC_9Dz_ndtMo0PIPktNre3z6rJoxEjmcsoCMekC3MdHk0NRK2Qq3ahpImH10pA6z5elDOLVKoy2MiirGNple336oHhh_4dLpD7oMEOcaAgU8CX0AVjSYeStbpxtzukwVvcA1CCJdhBrk3dD7pMjnAdQF49A2D14siXKQJm89cSvnEzIgidehWWY4PRdQ' \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: Insomnia/2023.5.7' \
  --cookie JSESSIONID=30FD64CA98B46417A8EACEA42976CB2C \
  --data '{
	"title": "Blade Runner 2049",
	"overview": "Thirty years after the events of the first film, a new blade runner, LAPD Officer K, unearths a long-buried secret that has the potential to plunge what’s left of society into chaos. K’s discovery leads him on a quest to find Rick Deckard, a former LAPD blade runner who has been missing for 30 years.",
	"runtime": 164,
	"genres": [ "Science_Fiction", "Drama"],
	"language": "English",
	"trailer": "https://www.youtube.com/watch?v=gCcx85zbxz4",
	"actors": ["Ryan Gosling", "Harrison Ford", "Ana de Armas", "Sylvia Hoeks", "Robin Wright", "Jared Leto", "Mackenzie Davis", "Carla Juri"],
	"releaseDate": "2017-10-05",
	"director": "Denis Villeneuve"
}'
```

Response

```json
{
	"id": 3,
	"title": "Blade Runner 2049",
	"overview": "Thirty years after the events of the first film, a new blade runner, LAPD Officer K, unearths a long-buried secret that has the potential to plunge what’s left of society into chaos. K’s discovery leads him on a quest to find Rick Deckard, a former LAPD blade runner who has been missing for 30 years.",
	"runtime": 164,
	"genres": [
		"Science_Fiction",
		"Drama"
	],
	"language": "English",
	"trailer": "https://www.youtube.com/watch?v=gCcx85zbxz4",
	"actors": [
		"Ryan Gosling",
		"Harrison Ford",
		"Ana de Armas",
		"Sylvia Hoeks",
		"Robin Wright",
		"Jared Leto",
		"Mackenzie Davis",
		"Carla Juri"
	],
	"releaseDate": "2017-10-04",
	"director": "Denis Villeneuve",
	"reviews": null
}
```

### Creating a review

Request

```shell
curl --request POST \
  --url http://localhost:8080/api/v1/reviews/movie/1 \
  --header 'Authorization: Bearer eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoicnlhbmdvc2xpbmciLCJpYXQiOjE2OTQxMDgwODQsInJvbGVzIjoiVVNFUiJ9.OXZb_aIcunRuU6Wd47Dr6L3gz13ic1XPFg8WtiyDbHvKlUYe_OjmL8IrJP0fZIioqchQAfTIJOgWFvsXgGc9nLr_L2LYPfV9XbGCHaWaFCmiHeK1DsqRJex2ZJyFvvWz-NmcU3HO0uklJBwMOMgRDtnuZwWVEOgCNncPFVi70sOSOUi7CeciLvfXLL5aYQ2JUFn2Uf_UjCo9YGZnTGvpGCNd0cAiJUzPAbIxoAnOgF0OaTBf3UrtjAP_7E1wUcj3sc5xOF-7gkL1_0kXMjkJ9ZqPiA5DC1Awq-aFVWdAQCTFzpd-cTgmdUtfZ9CbpDY9PTG6fZqr2wP-iwDpEIsHcA' \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: Insomnia/2023.5.7' \
  --cookie JSESSIONID=30FD64CA98B46417A8EACEA42976CB2C \
  --data '{
	"text": "We live in a society",
	"starRating": 5.0
}'
```

Response

```json
{
	"id": 5,
	"createdAt": "2023-09-07T14:35:46.615524",
	"text": "We live in a society",
	"starRating": 5.0
}
```

### Get all movies

Request

```shell
curl --request GET \
  --url http://localhost:8080/api/v1/movies \
  --header 'Authorization: Bearer eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoiYWRtaW4iLCJpYXQiOjE2OTQxMDc2MjcsInJvbGVzIjoiQURNSU4ifQ.jdwhBX6qQUxD2sI7WeX0iG3lVxOAU2s8ZmCPalsP4pen0DrIpWTj8Zso64qrHh-xygraf-55KWUjkk_KNyvbMNqwaMwSXiQ9uvrkIDHkgc1xaI8Ejuj9_gEt3e6Fc777qNPAfY6uA8Cuo7ymfOiCiAuNq1RC_9Dz_ndtMo0PIPktNre3z6rJoxEjmcsoCMekC3MdHk0NRK2Qq3ahpImH10pA6z5elDOLVKoy2MiirGNple336oHhh_4dLpD7oMEOcaAgU8CX0AVjSYeStbpxtzukwVvcA1CCJdhBrk3dD7pMjnAdQF49A2D14siXKQJm89cSvnEzIgidehWWY4PRdQ' \
  --header 'User-Agent: Insomnia/2023.5.7' \
  --cookie JSESSIONID=30FD64CA98B46417A8EACEA42976CB2C
```

Response

```json
[
	{
		"id": 1,
		"title": "Joker",
		"overview": "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",
		"runtime": 122,
		"genres": [
			"Crime",
			"Drama",
			"Thriller"
		],
		"language": "English",
		"trailer": "https://www.youtube.com/watch?v=zAGVQLHvwOY",
		"actors": [
			"Joaquin Phoenix",
			"Robert De Niro",
			"Zazie Beetz",
			"Frances Conroy",
			"Brett Cullen",
			"Shea Whigham",
			"Bill Camp",
			"Glenn Fleshler"
		],
		"releaseDate": "2019-10-03",
		"director": "Todd Phillips",
		"reviews": [
			{
				"id": 1,
				"createdAt": "2023-09-07T11:57:17.454968",
				"text": "You wouldn't get it",
				"starRating": 4.5
			},
			{
				"id": 5,
				"createdAt": "2023-09-07T14:35:46.615524",
				"text": "We live in a society",
				"starRating": 5.0
			}
		]
	},
	{
		"id": 3,
		"title": "Blade Runner 2049",
		"overview": "Thirty years after the events of the first film, a new blade runner, LAPD Officer K, unearths a long-buried secret that has the potential to plunge what’s left of society into chaos. K’s discovery leads him on a quest to find Rick Deckard, a former LAPD blade runner who has been missing for 30 years.",
		"runtime": 164,
		"genres": [
			"Science_Fiction",
			"Drama"
		],
		"language": "English",
		"trailer": "https://www.youtube.com/watch?v=gCcx85zbxz4",
		"actors": [
			"Ryan Gosling",
			"Harrison Ford",
			"Ana de Armas",
			"Sylvia Hoeks",
			"Robin Wright",
			"Jared Leto",
			"Mackenzie Davis",
			"Carla Juri"
		],
		"releaseDate": "2017-10-04",
		"director": "Denis Villeneuve",
		"reviews": [
			{
				"id": 3,
				"createdAt": "2023-09-07T14:33:27.00834",
				"text": "He's literally me",
				"starRating": 5.0
			},
			{
				"id": 4,
				"createdAt": "2023-09-07T14:35:07.530919",
				"text": "Work of art",
				"starRating": 5.0
			}
		]
	}
]
```

### Get a specific movie

Request

```shell
curl --request GET \
  --url http://localhost:8080/api/v1/movies/3 \
  --header 'Authorization: Bearer eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoidG9tYXMiLCJpYXQiOjE2OTQxMDc5ODQsInJvbGVzIjoiVVNFUiJ9.yEsUUMbVQ_itbK40d4dB6NORib-SoUscWqLC27qPXkcYx4cDYwx0pBTiYPJu9Rdkg4VqbUs4oljdbikG8zwyerWtv2hbLxVdXVeDPDBamqPdD5rsEOY4YlFZtGaD96yMnsxrQWLQRZTOZkICAVGYheuXzRsJG02qQT4z4ZQoKMVmDf1p6ejgYYq7uF8DLy94BnhcHA3_NIuRs_x_KB5J44kDjvl-XlXEulIdSyXFR1fDk-sDXWr0tT3w577K2JhthSe-mxV6ik6NupiMiLZDPyTafhG_p26z-MpKbLa8iQNvTZzI_8RK0gK3QSxmF-zg0Y59X7IF556r2pf4Rflecw' \
  --header 'User-Agent: Insomnia/2023.5.7' \
  --cookie JSESSIONID=30FD64CA98B46417A8EACEA42976CB2C
```

Response

```json
{
	"id": 3,
	"title": "Blade Runner 2049",
	"overview": "Thirty years after the events of the first film, a new blade runner, LAPD Officer K, unearths a long-buried secret that has the potential to plunge what’s left of society into chaos. K’s discovery leads him on a quest to find Rick Deckard, a former LAPD blade runner who has been missing for 30 years.",
	"runtime": 164,
	"genres": [
		"Science_Fiction",
		"Drama"
	],
	"language": "English",
	"trailer": "https://www.youtube.com/watch?v=gCcx85zbxz4",
	"actors": [
		"Ryan Gosling",
		"Harrison Ford",
		"Ana de Armas",
		"Sylvia Hoeks",
		"Robin Wright",
		"Jared Leto",
		"Mackenzie Davis",
		"Carla Juri"
	],
	"releaseDate": "2017-10-04",
	"director": "Denis Villeneuve",
	"reviews": [
		{
			"id": 3,
			"createdAt": "2023-09-07T14:33:27.00834",
			"text": "He's literally me",
			"starRating": 5.0
		}
	]
}
```

### Update a movie

Request

```shell
curl --request PATCH \
  --url http://localhost:8080/api/v1/movies/1 \
  --header 'Authorization: Bearer eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoiYWRtaW4iLCJpYXQiOjE2OTQxMDc2MjcsInJvbGVzIjoiQURNSU4ifQ.jdwhBX6qQUxD2sI7WeX0iG3lVxOAU2s8ZmCPalsP4pen0DrIpWTj8Zso64qrHh-xygraf-55KWUjkk_KNyvbMNqwaMwSXiQ9uvrkIDHkgc1xaI8Ejuj9_gEt3e6Fc777qNPAfY6uA8Cuo7ymfOiCiAuNq1RC_9Dz_ndtMo0PIPktNre3z6rJoxEjmcsoCMekC3MdHk0NRK2Qq3ahpImH10pA6z5elDOLVKoy2MiirGNple336oHhh_4dLpD7oMEOcaAgU8CX0AVjSYeStbpxtzukwVvcA1CCJdhBrk3dD7pMjnAdQF49A2D14siXKQJm89cSvnEzIgidehWWY4PRdQ' \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: Insomnia/2023.5.7' \
  --cookie JSESSIONID=30FD64CA98B46417A8EACEA42976CB2C \
  --data '{
	"actors": ["Joaquin Phoenix", "Robert De Niro", "Zazie Beetz", "Frances Conroy", "Brett Cullen", "Shea Whigham", "Bill Camp", "Glenn Fleshler"]
}'
```

Response

```json
{
	"id": 1,
	"title": "Joker",
	"overview": "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",
	"runtime": 122,
	"genres": [
		"Crime",
		"Drama",
		"Thriller"
	],
	"language": "English",
	"trailer": "https://www.youtube.com/watch?v=zAGVQLHvwOY",
	"actors": [
		"Joaquin Phoenix",
		"Robert De Niro",
		"Zazie Beetz",
		"Frances Conroy",
		"Brett Cullen",
		"Shea Whigham",
		"Bill Camp",
		"Glenn Fleshler"
	],
	"releaseDate": "2019-10-03",
	"director": "Todd Phillips",
	"reviews": [
		{
			"id": 1,
			"createdAt": "2023-09-07T11:57:17.454968",
			"text": "You wouldn't get it",
			"starRating": 4.5
		}
	]
}
```

### Delete a movie

Request

```shell
curl --request DELETE \
  --url http://localhost:8080/api/v1/movies/1 \
  --header 'Authorization: Bearer eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoidG9tYXMiLCJpYXQiOjE2OTQwMjIyODksInJvbGVzIjoiVVNFUiJ9.EF8bOOs3bzq02c0ATXAekBO2MWN4nqJhCOfE3E-ugGlUY--cuXjHI-XndvvBgh-UNILjzVdVLZ9Byd7FbKKzVICB1MF6WNHz9VP4XH5d-gUuaewegeLOz3JveU6-pCNKvfUtgebPoaM7dwnp3Ttq-Qy4FLnthzQQTPdeJfsTgLm6oI0GzF8Vbu5FNjpUoeYN2m4wLyWAcdhjTYcM00pzZ8MyjOH_PhoZYobc4jdpuIG0VU5e40P_B0fgSoQxcKY5JNYt2cRktYt6EneR5T_lLCw0gyWs9_XUIxpUE-UbQBBeh7LmGUpb1Fu_h13wYXKSMxE4Vv80t4PsIsK3KySFUw' \
  --header 'User-Agent: Insomnia/2023.5.7' \
  --cookie JSESSIONID=30FD64CA98B46417A8EACEA42976CB2C
```

Response

```json

```

### Get logged in user details

Request

```shell
curl --request GET \
  --url http://localhost:8080/api/v1/users/me \
  --header 'Authorization: Bearer eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoicnlhbmdvc2xpbmciLCJpYXQiOjE2OTQxMDk2MTEsInJvbGVzIjoiVVNFUiJ9.ANcEg3eNdOZ2BLHytq9CqNcBizLBDIGtm6tLfiKCOFdEivewrYA5qDJe7lJHOxfuUloVsv8xB3XOnHHY180twzWIuNUsF55SmBEQu7Um5r3yKd9yLS3Fqbitfbdv1WmEW37rz0d4zqkFvlAgAbHNpKFx13rQLJjV9XqfhlaWL92_NzFfpWptwJuuKVvfuaCOXGYg0kCuAGG1xRAa09aRrcF-cdCjHMrPOkSNracqn-b9OPe0k2AqUx70CPiNuPB-TcC69fVqmqdZd8pk20J-JWzVe6quzTkSA2dDqT_Q5kZRh1TqYH1TXu1Ngig7QnYHYEU1ElEPiFwyEvA5MIsgDA' \
  --header 'User-Agent: Insomnia/2023.5.7' \
  --cookie JSESSIONID=30FD64CA98B46417A8EACEA42976CB2C
```

Response

```json
{
	"userId": 16,
	"name": "Ryan Gosling",
	"email": "ryangosling@example.com",
	"username": "ryangosling",
	"reviews": [
		{
			"id": 4,
			"createdAt": "2023-09-07T14:35:07.530919",
			"text": "Work of art",
			"starRating": 5.0
		},
		{
			"id": 5,
			"createdAt": "2023-09-07T14:35:46.615524",
			"text": "We live in a society",
			"starRating": 5.0
		}
	],
	"enabled": true,
	"accountNonLocked": true,
	"credentialsNonExpired": true,
	"accountNonExpired": true
}
```

### Update user details

Request

```shell
curl --request PATCH \
  --url http://localhost:8080/api/v1/users/me \
  --header 'Authorization: Bearer eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoidG9tYXMiLCJpYXQiOjE2OTQwMjIyODksInJvbGVzIjoiVVNFUiJ9.EF8bOOs3bzq02c0ATXAekBO2MWN4nqJhCOfE3E-ugGlUY--cuXjHI-XndvvBgh-UNILjzVdVLZ9Byd7FbKKzVICB1MF6WNHz9VP4XH5d-gUuaewegeLOz3JveU6-pCNKvfUtgebPoaM7dwnp3Ttq-Qy4FLnthzQQTPdeJfsTgLm6oI0GzF8Vbu5FNjpUoeYN2m4wLyWAcdhjTYcM00pzZ8MyjOH_PhoZYobc4jdpuIG0VU5e40P_B0fgSoQxcKY5JNYt2cRktYt6EneR5T_lLCw0gyWs9_XUIxpUE-UbQBBeh7LmGUpb1Fu_h13wYXKSMxE4Vv80t4PsIsK3KySFUw' \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: Insomnia/2023.5.7' \
  --cookie JSESSIONID=30FD64CA98B46417A8EACEA42976CB2C \
  --data '{
	"email": "tomas@exmaple.com"
}'
```

Response

```json
{
	"userId": 15,
	"name": "Tomas",
	"email": "tomas@example.com",
	"username": "tomas",
	"picture": "",
	"reviews": [],
	"enabled": true,
	"accountNonLocked": true,
	"accountNonExpired": true,
	"credentialsNonExpired": true
}
```

### Get user details by username

Request 

```shell
curl --request GET \
  --url http://localhost:8080/api/v1/users/tomas \
  --header 'Authorization: Bearer eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoiYWRtaW4iLCJpYXQiOjE2OTQxMDM0NTYsInJvbGVzIjoiQURNSU4ifQ.gURLE1v2U8QzTk8QIsQLLcBtJ7IOCorzQlMcfG6i3ER3DgX7V0PmPj04Tw3H-8ccOZdV87cJSo8GbDPZdiEygHt7dVx_TGvK1fjNFrLAjtRgaNNGxRI1-_OIJIhledAERXRc7ZrhT_a1e9kSfS1ED-cEKqcEX2CoXxT8yogrtN1KeiPSDnZmoLr_nHntqfKbNbMv3FvEBzKfV6xdyQA5x9RTbTnrBUzNyajNRfIknLif0rjmn3rGiRmtVPtrqu_squ7VnvyHMVyTL8sazCByu0d7eUypPhSxt3pd-neaRUAoZyEcZ0TbR29nHH6DjuYfFZoa36_ZISPkxbgRA8qZdg' \
  --header 'User-Agent: Insomnia/2023.5.7' \
  --cookie JSESSIONID=30FD64CA98B46417A8EACEA42976CB2C
```

Response

```json
{
	"userId": 15,
	"name": "Tomas",
	"email": "tomas@example.com",
	"username": "tomas",
	"picture": "",
	"reviews": [
		{
			"id": 1,
			"createdAt": "2023-09-07T11:57:17.454968",
			"text": "You wouldn't get it",
			"starRating": 4.5
		}
	],
	"enabled": true,
	"accountNonLocked": true,
	"accountNonExpired": true,
	"credentialsNonExpired": true
}
```

