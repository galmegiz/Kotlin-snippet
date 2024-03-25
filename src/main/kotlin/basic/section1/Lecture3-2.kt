package basic.section1

fun main(){

    val age = 10
    val name = "선종우"
    System.out.println(String.format("이름 : %s", name))

    println("이름 : $name")

    """
        여러 줄의 
        문자열을 자유롭게 작성할 수 있다
        $name
    """.trimIndent()

    // 문자열 각 인덱스 접근 시
    name[0] // name.charAt(0)
}
