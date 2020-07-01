import java.util.*

/**
 * A simulation of an automatic teller machine
 */
object ATM {
    var keyboard = Scanner(System.`in`)
    var acctNum: String? = null
    var pwd: String? = null
    var result: String? = null
    var oldBalance = 0.0
    var newBalance = 0.0
    var deposit = 0.0
    var withdraw = 0.0
    var currentBalance = 0.0
    var choose = 0

    @JvmStatic
    fun main(args: Array<String>) {
        for (run in 0..2) {
            println("Enter your account number")
            acctNum = keyboard.nextLine()
            println("Enter your account password")
            pwd = keyboard.nextLine()
            result = checkID(acctNum, pwd)
            if (result != "ERROR") {
                break
            } else if (run == 2) { // you cannot try to log in anymore than 3
                // times
                println("MAXIMUM TRIES EXCEEDED")
                return
            }
        }
        menu()
    }

    fun checkID(acctNum: String?, pwd: Any?): String? {
        var result = "ERROR"
        val a = "44567-5 mypassword 520.36"
        val b = "1234567-6 anotherpassword 48.20"
        val c = "4321-0 betterpassword 96.74"
        if (acctNum == "2345" && pwd == "2345") {
            result = "520.36"
        } else if (acctNum == "1234567-6" && pwd == "anotherpassword") {
            result = "48.20"
        } else if (acctNum == "4321-0" && pwd == "betterpassword") {
            result = "96.74"
        }
        println(result)
        return result
    }

    fun menu(): Int {
        println("Choose one of the following: \n1.Display Balance\n2.Deposit\n3.Withdraw\n4.Log Out")
        choose = keyboard.nextInt()
        if (choose == 1) { // 1. Display Balance
            displayBalance()
            menu()
            return 1
        }
        if (choose == 2) { // 2. Deposit
            deposit()
            menu()
            return 2
        }
        if (choose == 3) { // 3. Withdraw
            withdraw()
            menu()
            return 3
        }
        if (choose == 4) { // 4. Log out
            println("You are logged out.")
            return 4
        }
        if (choose <= 5) { // type in anything greater than 4 and you will get a
            // system error
            println("System Error")
            menu()
            return 5
        }
        if (choose >= 1) { // type in anything less than 1 and you will get a
            // system error
            println("System Error")
            menu()
            return 6
        }
        return choose
    }

    fun deposit() {
        val input = Scanner(System.`in`)
        println("Enter deposit amount:")
        val amount = input.nextDouble()
        println("Your deposit amount: $amount")
        currentBalance += amount
        println("Your new balance is: $currentBalance")
    }

    fun displayBalance(): Int {
        println("Total balance is: $$currentBalance")
        oldBalance = 0.00
        return 1
    }

    fun withdraw() {
        val input = Scanner(System.`in`)
        println("Enter withdrawal amount: ")
        val amount = input.nextDouble()
        println("Your withdrawal amount: $amount")
        currentBalance -= amount
        println("Your new balance is: $currentBalance")
    }
}