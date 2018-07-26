sealed abstract class CellState
case object Empty extends CellState
case object Maru extends CellState


class Board(val cells: Map[(Int,Int), Int]) {

  def put(row: Int, column: Int, putNum: Int):Board = {
    new Board(cells + ((row, column) -> putNum))
  }

  def canPut(row: Int, column: Int): Boolean = cells((row, column)) == Empty

  override def toString = s"Board($cells)"

  def drawBoard(board :Board):Unit = {
    for(row <- 0 to 10; column <- 0 to 10) {
      if(row == 10) {
        println()
      }
      printf("%3s",board.cells.getOrElse((row,column), "Default"))
    }
  }


}

object Board {
  def apply(): Board = {
    val keyValues = for(row <- 0 to 10; column <- 0 to 10) yield (row, column) -> 0
    new Board(keyValues.toMap)
  }
}
