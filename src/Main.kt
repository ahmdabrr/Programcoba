import java.util.*

object ATM_Transaction {
    @JvmStatic
    fun main(args: Array<String>) {
        var balance = 5000
        var withdraw: Int
        var deposit: Int
        val s = Scanner(System.`in`)
        while (true) {
            println("Automated Teller Machine")
            println("Choose 1 for Withdraw")
            println("Choose 2 for Deposit")
            println("Choose 3 for Check Balance")
            println("Choose 4 for EXIT")
            print("Choose the operation you want to perform:")
            val n: Int = s.nextInt()
            when (n) {
                1 -> {
                    print("Enter money to be withdrawn:")
                    withdraw = s.nextInt()
                    if (balance >= withdraw) {
                        balance = balance - withdraw
                        println("Please collect your money")
                    } else {
                        println("Insufficient Balance")
                    }
                    println("")
                }
                2 -> {
                    print("Enter money to be deposited:")
                    deposit = s.nextInt()
                    balance = balance + deposit
                    println("Your Money has been successfully depsited")
                    println("")
                }
                3 -> {
                    println("Balance : $balance")
                    println("")
                }
                4 -> System.exit(0)
            }
        }
    }
}