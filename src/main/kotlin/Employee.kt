class Employee(
        private val name: String,
        private val document: String,
        private val salary: Double
) {
    fun bonus(): Double {
        return this.salary * 0.1
    }

}