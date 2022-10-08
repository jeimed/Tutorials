package main

import (
	"fmt"
	"strconv"
)

func main() {
	s := "ollo"
	i := 145
	sr := reverse(s)
	fmt.Println(s, " reversed: ", sr)
	fmt.Println(s, " is palidrome: ", isPalindrome(s))
	fmt.Println(i, " reversed: ", reverseInt(i))

}

func reverse(s string) string {
	strLen := len(s)

	if strLen < 2 {
		return s
	}

	var rslt string

	for _, letter := range s {
		rslt = string(letter) + rslt
	}
	return rslt
}

func isPalindrome(s string) bool {
	rslt := reverse(s)
	return rslt == s
}

func reverseInt(i int) int {
	isPositive := i > 0
	if !isPositive {
		i = i * -1
	}

	s := strconv.Itoa(i)
	iRev, err := strconv.Atoi(reverse(s))

	if err != nil {
		fmt.Println(err)
	}

	if isPositive {
		iRev = iRev * -1
	}

	return iRev
}
