//Create Read Update Delete
// DELETE(DELETES) Deletes an existing entry

fetch("http://localhost:8080/movies", {
    method: 'DELETE',
    headers: {
        'Content-Type': 'application/json'
    },
    redirect: 'follow',
    body: JSON.stringify(11)
}).then(function(response) {
    return response.json();
}).then(function(data) {
    console.log(data);
});