/**
 *
 */
var addMinText = document.getElementById('people');
var pay = document.getElementById('pay');
var payment;

function addPeople() {
    var people = addMinText.value;
    addMinText.value = ++people;
    payment = people * 2000;
    pay.value = payment + "원";
}

function minPeople() {
    var people = addMinText.value;
    if (people > 1) {
        addMinText.value = --people;
        payment = people * 2000;
        pay.value = payment + "원";
    }
}