var view = {
	displayMessage : function (msg) 
	{
		var messageArea = document.getElementById("messageArea");
		messageArea.innerHTML = msg;
	},

	displayMiss : function (location) 
	{
		var cell = document.getElementById(location);
		cell.setAttribute("class", "miss");	
	},

	displayHit : function (location) 
	{
		var cell = document.getElementById(location);
		cell.setAttribute("class", "hit");
	}
}

var model = {
	boardSize : 7,
	//numShips: 3,
	shipLength: 3,
	shipSunk : 0,

	ships : [
		{ 
			locations : [0, 0, 0], 
			hits : ["", "", ""] 
		},
		{ 
			locations : [0, 0, 0], 
			hits : ["", "", ""] 
		},
		{ 
			locations : [0, 0, 0], 
			hits : ["", "", ""]
		}
	],

	fire : function (guess) 
	{

		for (var i = 0; i < this.ships.length; i++) {

			var ship = this.ships[i];
			var index = ship.locations.indexOf(guess);

			if (index >= 0) {

				if (ship.hits[index] === "hit")	{
					view.displayMessage("Вы уже стреляли в эту клетку!");
					return false;
				}
				
				ship.hits[index] = "hit";
				view.displayHit(guess);
				view.displayMessage("Ранил!");

				if (this.isSunk(ship)) {
					
					this.shipSunk++;
					view.displayMessage("Убил!");

				}
				return true;
			}
		}

		view.displayMiss(guess);
		view.displayMessage("Мимо!");
		return false;
	},

	isSunk : function (ship) 
	{
		for (var i = 0; i < ship.hits.length; i++) {
			if (ship.hits[i] !== "hit") {
				return false;
			}
		}
		return true;
	},

	generateShipLocation : function ()
	{
		var locations;

		for (var i = 0; i < this.ships.length; i++) {
			do {

				locations = this.generateShip();

			} while (this.collision(locations));
			this.ships[i].locations = locations;
		}
	},

	generateShip : function ()
	{
		var direction = Math.floor(Math.random() * 2);
		var row, col;

		if (direction === 1) {
			row = Math.floor(Math.random() * this.boardSize);
			col = Math.floor(Math.random() * (this.boardSize - this.shipLength));
		} else {
			row = Math.floor(Math.random() * (this.boardSize - this.shipLength));
			col = Math.floor(Math.random() * this.boardSize);
		}

		var newShipLocations = [];

		for (var i = 0; i < this.shipLength; i++) {
			if (direction === 1) {
				newShipLocations.push(row + "" + (col + i));
			} else {
				newShipLocations.push((row + i) + "" + col);
			}
		}
		return newShipLocations;
	},

	collision : function (locations)
	{
		for (var i = 0; i < this.ships.length; i++) {
			var ship = this.ships[i];
			for (var j = 0; j < locations.length; j++) {

				if (ship.locations.indexOf(locations[j]) >= 0) {

					return true;
				}
			}
		}
		return false;
	}
}

var controller = {
	guesses : 0,

	processGuess: function (guess) 
	{
		guess = this.parseGuess(guess);

		if (!guess) {
			alert("Неправильный ввод");
			return false;
		}

		this.guesses++;
		var hit = model.fire(guess);

		if (hit && model.shipSunk === model.ships.length) {

			alert("Победа!");
			view.displayMessage("Вы потапили все корабли. <br>Колличество поыток = " 
				+ this.guesses 
				+ "<br>F5 для Новой игры");
			var fireForm = document.getElementById("fireForm");
			fireForm.remove();

		}	
	},

	parseGuess : function (guess) 
	{
		if (guess === "" ||	guess.length !== 2) {return null;}

		var x1 = guess.charAt(0);
		var x2 = guess.charAt(1);
		x1 = x1.toUpperCase();

		if (x1 === "A") {x1 = 0;} 
		else if (x1 === "B") {x1 = 1;} 
		else if (x1 === "C") {x1 = 2;} 
		else if (x1 === "D") {x1 = 3;} 
		else if (x1 === "E") {x1 = 4;} 
		else if (x1 === "F") {x1 = 5;} 
		else if (x1 === "G") {x1 = 6;} 
		else {return null;}

		if (x2 < 0 || x2 > 6 || isNaN(x2)) {return null;}

		return  String(x1) + String(x2);
	}
}

window.onload = init;

function init () 
{
	model.generateShipLocation();

	var fireButton = document.getElementById("fireButton");
 	fireButton.onclick = handleFireButton;

 	//Enter Block
 	var guessInput = document.getElementById("guessInput");
 	guessInput.onkeypress = handleKeyButton;
}

function handleFireButton() 
{
	var guessInput = document.getElementById("guessInput");
	var inputText = guessInput.value.trim();
	guessInput.value = "";
	controller.processGuess(inputText);
}

function handleKeyButton(e) 
{
	var fireButton = document.getElementById("fireButton");

	if (e.keyCode === 13) {
		fireButton.click();
		return false;
	} 
}