package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	var score_sum float64
	var mul_sum float64

	reader := bufio.NewReader(os.Stdin)

	for i := 0; i < 20; i++ {
		str, _ := reader.ReadString('\n')
		str = str[:len(str)-1]

		words := strings.Split(str, " ")

		score, _ := strconv.ParseFloat(words[1], 64)
		grade := words[2]

		if grade == "P" {
			continue
		}

		grade_score := get_grade_score(grade)

		score_sum += score
		mul_sum += grade_score * score
	}

	fmt.Println(mul_sum / score_sum)
}

func get_grade_score(grade string) float64 {
	var grade_score float64

	switch grade {
	case "A+":
		grade_score = 4.5
	case "A0":
		grade_score = 4.0
	case "B+":
		grade_score = 3.5
	case "B0":
		grade_score = 3.0
	case "C+":
		grade_score = 2.5
	case "C0":
		grade_score = 2.0
	case "D+":
		grade_score = 1.5
	case "D0":
		grade_score = 1.0
	case "F":
		grade_score = 0.0
	}

	return grade_score
}
