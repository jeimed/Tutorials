package main

import (
	"fmt"
	"strconv"
)

func main() {
	num := 15

	s := fizzBuzz(num)

	fmt.Println(s)
}

func fizzBuzz(num int) string {
	var s string

	for i := 1; i <= num; i++ {
		if i%3 == 0 && i%5 == 0 {
			s += "fizzbuzz"
		} else if i%3 == 0 {
			s += "fizz"
		} else if i%5 == 0 {
			s += "buzz"
		} else {
			s += strconv.Itoa(i)
		}
		s = s + " "
	}
	return s
}
