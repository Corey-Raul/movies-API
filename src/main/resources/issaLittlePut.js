//Create Read Update Delete
// PUT(READ) updates an existing entry/row = to one movie
fetch("http://localhost:8080/movies", {
    method: 'PUT',
    headers: {
        'Content-Type': 'application/json'
    },
    redirect: 'follow',
    body: JSON.stringify({
        title: "UPDATED MOVIE",
        year: "2008",
        director: "Tarun Mansukhani",
        actors: "Abhishek Bachchan, John Abraham, Priyanka Chopra",
        imdbID: "tt1185420",
        poster: "https://m.media-amazon.com/images/M/MV5BOTE0NDU1ZTctYjRjYS00OTEyLTkzOWQtNmRiNDg5ZDU1ODBiXkEyXkFqcGdeQXVyNjQ2MjQ5NzM@._V1_SX300.jpg",
        genre: "Comedy, Drama, Romance",
        plot: "Two straight guys pretend to be gay in order to secure a Miami apartment. When both of them fall for their roommate Neha, hilarity ensues as they strive to convince one and all that they're gay whilst secretly trying to win her heart",
        id: 11
    })
}).then(function (response) {
    return response.json();
}).then(function (data) {
    console.log(data);
});