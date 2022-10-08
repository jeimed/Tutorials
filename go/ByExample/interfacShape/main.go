package main

import (
	"fmt"
	"math"
)

type shape interface {
	area() float32
}

type circle struct {
	radius float32
}
type rectangle struct {
	width, height float32
}

func (r rectangle) area() float32 {
	return r.width * r.height
}

func (c circle) area() float32 {
	return math.Pi * c.radius * c.radius
}

func getArea(s shape) float32 {
	return s.area()
}

func main() {
	r := rectangle{width: 3.35, height: 4.25}
	c := circle{radius: 5.1}
	fmt.Printf("circle area: %.2f\n", getArea(c))
	fmt.Printf("rect area: %.2f\n", getArea(r))
}
