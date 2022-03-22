package triad3

@scala.annotation.tailrec
def cmin(vals: Double*)(snum: Int = 1, prevs: Set[Seq[Boolean]] = Set()): Int =

  val calc = (x: Double, snum: Int) =>
    ((snum * x).ceil * 100 / snum).floor == (x * 100).round

  val valid = (vals zip (0 to vals.length)).foldLeft(true)((l, r) =>
    l && (calc(r._1, snum) || prevs.filter(_(r._2)).nonEmpty)
  )
  if (valid) snum else cmin(vals*)(snum + 1, prevs + vals.map(calc(_, snum)*))


@main def main() = println(s"\nsuccess: ${cmin(((40 to 63).map(_ * 0.01))*)()}\n")
