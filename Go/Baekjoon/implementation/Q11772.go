package main

import (
	"fmt"
	"strconv"
)

func main() {
	var n int
	var sum int
	fmt.Scan(&n)

	for i := 0; i < n; i++ {
		var num string
		fmt.Scan(&num)

		_len := len(num)
		a, _ := strconv.Atoi(num[:_len-1])
		b, _ := strconv.Atoi(num[_len-1:])

		y := 1

		for j := 0; j < b; j++ {
			y *= a
		}

		sum += y
	}

	fmt.Print(sum)
}
