package main

import (
	"fmt"
	"strings"

	"golang.org/x/text/cases"
	"golang.org/x/text/language"
)

func main() {
	str := "hello world"
	strCaps := capitalizeFirstLetter(str)
	fmt.Println("'" + strCaps + "'")
}

func capitalizeFirstLetter(str string) string {
	var rtn string
	strs := strings.Split(str, " ")
	//caser := cases.Title(language.Und)
	for _, s := range strs {
		//rtn += strings.Title(s) + " "
		rtn += cases.Title(language.English, s).String() + " "
	}
	return strings.Trim(rtn, " ")

	// rslt := []rune(str)
	// for i, r := range rslt {

	// }
	//	for i=0; i < len(rslt), i++ {
	//	}

}
