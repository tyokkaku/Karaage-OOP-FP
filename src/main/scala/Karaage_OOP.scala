class Bento (var dish:String, var num:Int) {
  def show(): Unit = println(s"${this.dish}, ${this.num}")
}

object Bento {
  def apply(dish: String, num:Int) = new Bento(dish, num)
}

object eatBento_OOP extends App {
  val Karaben1 = Bento("唐揚げ", 10)
  val Karaben2 = Bento("唐揚げ", 8)
  val Karaben3 = Bento("唐揚げ", 6)

  val order:List[Bento] = List(Karaben1,Karaben2,Karaben3)

  val eat = 5

  // eat回繰り返す
  for(i <- 1 to eat) {
    var maxIndex = 0

    // 個数が最大の弁当を探す
    for(j <- 0 until order.length) {
      maxIndex = if( order(maxIndex).num > order(j).num) maxIndex else j
    }

    // 1個食べる
    order(maxIndex).num -= 1

    // 表示
    println("---------")
    for(i <- 0 until order.length) order(i).show()
  }
}

//  状態
//  主食名
//  唐揚げ個数
//  値段
//  …

//  振る舞い
//  つまみ食い()
//  値段取得()
//  唐揚げ個数取得()
