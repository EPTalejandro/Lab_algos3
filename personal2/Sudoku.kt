fun main(args:Array<String>){

    val sudokuInicial: String = args[0]
    if(sudokuInicial.length != 81){
        println("El sudoku dado no tiene las dimenciones requeridas")
        return
    }

    var col:Int = 0
    var fil: Int = 0
    var matriz: MutableList<MutableList<Int>> = MutableList(9){MutableList(9){0}} 
    for(num in sudokuInicial){
        if(col == 9){
            fil ++
            col = 0
        }
        matriz[fil][col] = num.digitToInt()
        col++
        
    }

    if(sudoku(matriz,0,0)){
        println(matriz.flatten().joinToString(""))
    }
    else{
        println("NOSOLUTION")
    }
}

fun sudoku(entrada: MutableList<MutableList<Int>>,fila:Int,columnna:Int):Boolean{

    var fil:Int = fila
    var col:Int = columnna

    if(fila == 8 && columnna == 9) return true

    if(columnna==9){
        col = 0
        fil++
    }

    if(entrada[fil][col]!= 0) return sudoku(entrada,fil,col+1)

    for (num in 1..9){
        if(esValida(num,fil,col,entrada)){
            entrada[fil][col]=num
            if(sudoku(entrada,fil,col+1)) return true
            entrada[fil][col] = 0
        }
    }

    return false

}

fun esValida(valor:Int,fila:Int,columnna:Int,matrix:MutableList<MutableList<Int>>): Boolean{

    // revisamos a ver si la jugada es valida en esa columnna
    for (num in 0..8){
        if (matrix[num][columnna] == valor) return false
    }
    // revisamos si la jugada es valida en esa fila
    for (num in 0..8){
        if (matrix[fila][num] == valor) return false
    }

    var filInicio:Int = fila -(fila%3)
    var colInicio:Int = columnna - (columnna%3)
    for (i in 0..2){
        for (j in 0..2){
            if (matrix[i + filInicio][j+colInicio]==valor) return false
        }
    }
    return true
}