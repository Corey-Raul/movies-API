//Create Read Update Delete
// POST(CREATE) ADDS an existing entry
fetch("http://localhost:8080/movies", {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    redirect: 'follow',
    body: JSON.stringify([{
        "title": "black hawk down",
        "rating": "4",
        "poster": "https://m.media-amazon.com/images/M/MV5BYWMwMzQxZjQtODM1YS00YmFiLTk1YjQtNzNiYWY1MDE4NTdiXkEyXkFqcGdeQXVyNDYyMDk5MTU@._V1_SX300.jpg",
        "year": "2001",
        "genre": "Drama, History, War",
        "director": "Ridley Scott, Test",
        "plot": "160 elite U.S. soldiers drop into Somalia to capture two top lieutenants of a renegade warlord and find themselves in a desperate battle with a large force of heavily-armed Somalis.",
        "actors": "Josh Hartnett, Ewan McGregor, Tom Sizemore, Eric Bana",
        "id": 1
    },
        {
            "title": "tenet",
            "rating": "0",
            "poster": "https://m.media-amazon.com/images/M/MV5BYzg0NGM2NjAtNmIxOC00MDJmLTg5ZmYtYzM0MTE4NWE2NzlhXkEyXkFqcGdeQXVyMTA4NjE0NjEy._V1_SX300.jpg",
            "year": "2020",
            "genre": "Action, Sci-Fi",
            "director": "Christopher Nolan",
            "plot": "Armed with only one word, Tenet, and fighting for the survival of the entire world, a Protagonist journeys through a twilight world of  international espionage on a mission that will unfold in something beyond real time. Armed with only one word, Tenet, and fighting for the survival of the entire world, a Protagonist journeys through a twilight world of ",
            "actors": "Elizabeth Debicki, Robert Pattinson, John David Washington, Aaron Taylor-Johnson",
            "id": 2
        }])
}).then(function (response) {
    return response.json();
}).then(function (data) {
    console.log(data);
});