var scores = 
	[ 
	60, 50, 60, 58, 54, 54,
	58, 50, 52, 54, 48, 69,
	34, 55, 51, 52, 44, 51,
	69, 64, 66, 55, 52, 61,
	46, 31, 57, 52, 50, 50,
	41, 53, 55, 61, 51, 44
	];

var costs = 
	[ 
	.15, .35, .60, .58, .44, .54,
	.58, .50, .52, .54, .48, .22,
	.34, .55, .51, .52, .44, .51,
	.25, .64, .66, .55, .52, .61,
	.46, .31, .57, .52, .44, .43,
	.41, .53, .55, .61, .51, .44
	];

function printAndFindMax(vals)
{
	var max = 0;
	for (i = 0; i < vals.length; i++) {
		document.writeln("Bubble solution #" + i + " score: " + vals[i] + "<br>");
		if (max < vals[i]) {
			max = vals[i];
		}
	}
	return max;
}

function getBestSolutions(vals, highScore)
{
	var bestSolutions = []
	
	for (i = 0; i < vals.length; i++) {
		if (vals[i] == highScore) {
			bestSolutions.push(i);
		}
	}
	return bestSolutions;
}

function getMostEffectiveSolution(bestSolutions, costs)
{
	var lowCoster = costs[bestSolutions[0]];
	var index = bestSolutions[0];

	for (var i = 0; i < bestSolutions.length; i++) {
		if (lowCoster > costs[bestSolutions[i]]) {
			lowCoster = costs[bestSolutions[i]];
			index = bestSolutions[i];
		}
	}
	return index;
}

var maxScore = printAndFindMax(scores);

document.writeln("<br>Bubble tests: " + scores.length);
document.writeln("<br>Highest bubble score: " + maxScore);

var bestSolutions = getBestSolutions(scores, maxScore);
document.writeln("<br>Solutions with highest scores: " + bestSolutions);

var mostEffective = getMostEffectiveSolution(bestSolutions, costs);
document.writeln("<br>Solution #" + mostEffective + " are most effective");