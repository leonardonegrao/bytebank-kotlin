open class Employee(
        val name: String,
        val document: String,
        val salary: Double
) {
    open fun bonus(): Double = this.salary * 0.1
}