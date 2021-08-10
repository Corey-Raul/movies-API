//Create Read Update Delete
// GET(READ) ALL existing entries unless specified
fetch("http://localhost:8080/movies", {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json'
    },
    redirect: 'follow',
}).then(function(response) {
    return response.json();
}).then(function(data) {
    console.log(data);
});