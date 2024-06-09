package main

import "fmt"

func main() {
	var n int
	fmt.Scanln(&n)

	y1 := 0
	y2 := 0

	for i := 0; i < n; i++ {
		var t int
		fmt.Scan(&t)

		y1 += 10 * (t/30 + 1)
		y2 += 15 * (t/60 + 1)
	}

	if y1 == y2 {
		fmt.Printf("Y M %d", y1)
	} else if y1 < y2 {
		fmt.Printf("Y %d", y1)
	} else if y1 > y2 {
		fmt.Printf("M %d", y2)
	}
}
