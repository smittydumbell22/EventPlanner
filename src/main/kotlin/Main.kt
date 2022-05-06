fun main(args: Array<String>) {
    println("Welcome")

    /*A greeting followed by display of menu. User can choose to create, edit, or exit.*/
    var selection = askSelection(arrayOf("Create", "Edit", "Exit"))
    while (selection != 3) {


        when (selection) {
            1 -> {
                val event = Event()
                event.promptName()
                println(event.name)
                var selection = askSelection(arrayOf("Guests", "Food", "Done"))
                /* if the user chooses 1 for create, the program will ask them to name
                 the event they would like to create. Once they name the event, a display with the event name and three
                 new options appears. The new options are Guests, Food, and Done.*/
                while (selection != 3) {
                    when (selection) {
                        1 -> {
                            event.displayGuests()
                            var selection = askSelection(arrayOf("Add Guests", "Remove Guests", "Done"))
                            /*displays guests, and allows user to edit guest list in the form of adding and removing.*/
                            while (selection != 3) {
                                when (selection) {
                                    1 -> {
                                        print("Guest Name: ")
                                        val guest = readLine()!!
                                        event.addGuest(guest)
                                    }
                                    2 -> {
                                        event.removeGuest()
                                    }
                                }
                                selection = askSelection(arrayOf("Add Guests", "Remove Guests", "Done"))
                            }
                        }
                        2 -> {
                            event.displayFoods()
                            var selection = askSelection(arrayOf("Add Food", "Remove Food", "Done"))
                            /*displays guests, and allows user to edit guest list in the form of adding and removing.*/
                            while (selection != 3) {
                                when (selection) {
                                    1 -> {
                                         print("Food Name: ")
                                         val food = readLine()!!
                                         event.addFood(food)

                                    }
                                    2 -> {
                                        event.removeFood()
                                    }
                                }
                                selection = askSelection(arrayOf("Add Food", "Remove Food", "Done"))
                            }
                        }
                    }
                    selection = askSelection(arrayOf("Guests", "Food", "Done"))


                }
            }
            2 -> {
                println("editing")
            }
            3 -> {
                println("exiting")
            }
        }
        selection = askSelection(arrayOf("Create", "Edit", "Exit"))
    }
}

fun askSelection(options: Array<String>): Int {
    var i = 1
    for (option in options) {
        println("$i. $option")
        i++

    }
    print("Please make a selection: ")
    val selection = readLine()!!.toInt()
    return selection
}

class Event {
    var name = ""
    var guests: MutableList<String> = mutableListOf<String>()
    var foods: MutableList<String> = mutableListOf<String>()


    fun promptName() {
        print("Event Name: ")
        name = readLine()!!
    }

    fun addGuest(guest: String) {
        guests.add(guest)
        displayGuests()

    }

    fun removeGuest() {
        val guestIndex = askSelection(guests.toTypedArray())
        guests.removeAt(guestIndex - 1)
        displayGuests()
    }

    fun displayGuests() {
        println("Guests")
        for (guest in guests) {
            println("\t$guest")
        }

    }
    fun displayFoods() {
        println("Foods")
        for (food in foods) {
            println("\t$food")
        }

    }
    fun addFood(food: String) {
        foods.add(food)
        displayFoods()

    }

    fun removeFood() {
        val foodIndex = askSelection(foods.toTypedArray())
        foods.removeAt(foodIndex - 1)
        displayFoods()
    }
}
