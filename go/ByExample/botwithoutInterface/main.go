package main

import "fmt"

type englishBot struct{}
type spanishBot struct{}

func main() {
	eb := englishBot{}
	sb := spanishBot{}
	printGreeting1(eb)
	printGreeting(sb)
}

func printGreeting1(eb englishBot) {
	fmt.Println(eb.getGreenting())
}

func printGreeting(sb spanishBot) {
	fmt.Println(sb.getGreenting())
}

func (eb englishBot) getGreenting() string {
	return "hello"
}

func (sp spanishBot) getGreenting() string {
	return "hola"
}
