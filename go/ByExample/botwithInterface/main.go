package main

import "fmt"

type englishBot struct{ name string }
type spanishBot struct{ fname, lname string }

type bot interface {
	getGreeting() string
}

func main() {
	eb := englishBot{"john"}
	sb := spanishBot{"Juan", "Diego"}
	printGreeting(eb)
	printGreeting(sb)
}

func printGreeting(b bot) {
	fmt.Println(b.getGreeting())
}

func (eb englishBot) getGreeting() string {
	return "hello " + eb.name
}

func (sp spanishBot) getGreeting() string {
	return "hola " + sp.fname + " " + sp.lname
}
