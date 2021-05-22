document.addEventListener("DOMContentLoaded", function () {
    console.log("Loaded");
    var testButton = document.getElementById('asyncTest');
    testButton.addEventListener("click", () => {
        console.log("clicked");
    })
});

const request = new XMLHttpRequest();
const GET = "GET"
request.open(GET, 'http://localhost:8080/');
request.send();
request.onload = () => {
    console.log(request);
    if (request.status === 200) console.log(JSON.parse(request.response));
    else console.error(`error ${request.status} ${request.statusText}`);
}