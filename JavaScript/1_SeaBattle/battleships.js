var location1 = Math.floor(Math.random() * 5);
var location2 = location1 + 1;
var location3 = location2 + 1;
var guess;
var hits = 0;
var guesses = 0;
var isSunk = false;

// console.log("Answers:");
// console.log(location1 + " " + location2 + " " + location3);

while (!isSunk) {

	guess = prompt("Enter attempt. Number from 0-6")

	if (guess < 0 || guess > 6 || !isFinite(guess)) {
		alert("Wrong value. Try again")
	} else {

		guesses++;

		if (guess == location1) {

			hits++;
			alert("You hit!");
			location1 = -1;

		} else if (guess == location2) {

			hits++;
			alert("You hit!");
			location2 = -1;
				
		} else if (guess == location3) {

			hits++;
			alert("You hit!");
			location3 = -1;

		} else if (guess == null) {

			alert("You give up. I won");
			isSunk = true;

		} else {
			alert("You miss!");
		}

		//exit
		if (hits == 3) {
			alert("You won! Number of guesses: " + guesses);
			isSunk = true;
		}
	}
}