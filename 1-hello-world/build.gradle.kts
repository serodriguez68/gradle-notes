tasks.create("printHello") {
    doLast {
        println("Hello World - Version $version")
    }
}