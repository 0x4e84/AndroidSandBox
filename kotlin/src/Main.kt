fun main(args: Array<String>)
{
    if (args.isEmpty()) {
        println("No parameter")
    } else {
        for (argument in args[0]) {
            println("argument: $argument")
        }
    }
}