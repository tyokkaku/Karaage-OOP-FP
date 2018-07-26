
object Karaage_FP extends App {

  // データの定義
  case class Bento(dish: String, num:Int)
  val Karaben1 = Bento("唐揚げ", 10)
  val Karaben2 = Bento("唐揚げ", 8)
  val Karaben3 = Bento("唐揚げ", 6)

  // データの準備
  val order = List(Karaben1,Karaben2,Karaben3)

  // データを個別に表示
  val show = (d: Bento) => println(s"${d.dish}, ${d.num}個")

  // すべてのデータを表示する
  val showAll = (bentoList: List[Bento]) => bentoList.foreach(show)

  // order から num が最大のケースクラスを見つける
  val selectEatingBento:(List[Bento]) => Bento = (bentoList: List[Bento]) => bentoList match {
    case List(x) => x
    case x::xs => val m = selectEatingBento(xs); if(m.num > x.num) m else x
  }

  // order から num が最大のケースクラスの num を1減少させた 新しいリスト を返す
  val eatingKaraage:(List[Bento]) => List[Bento] = (bentoList: List[Bento]) =>  {
    bentoList.map(x => if(x eq selectEatingBento(bentoList)) x.copy("唐揚げ", num = x.num -1) else x)
  }

  // 指定回数分、eating を実行する
  val eating:(Int, List[Bento]) => Unit = (eatNum: Int, lst: List[Bento]) => {
    println("--------")
    showAll(lst)
    if(eatNum > 0) eating(eatNum - 1, eatingKaraage(lst))
  }

  eating(5,order)
}



// リストの中から、フィールドが最大値を持つケースクラスを見つける
  // 入力： ケースクラスの入ったリスト
  // 出力： 最大値を持ったオブジェクト

// 最大値を持つオブジェクトのフィールドを1減少する
  // 最大値を持ったオブジェクト
  // 減少させたオブジェクトに更新したリスト

// 指定回数、2を繰り返す
  // 回数と、リスト
  // なし
