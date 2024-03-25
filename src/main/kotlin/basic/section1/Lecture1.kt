package basic.section1

/**
 * 코틀린 변수선언에 대해 다룬다
 *
 * 코틀린의 진입점(entry point)는 top-level 메인함수이다
 * 메인 함수에는 Array<String>형 매개변수를 전달할 수 있다
 * ex) fun main(args: Array<String>)
 */
fun main(){
    var number1: Long = 10L
    val number2: Long = 10L

    number1 = 5L // var 변수의 경우 값을 수정할 수 있다
    val number3: Long = 1_000L // 코드 작성 시에는 primitive 타입과 reference 타입을 구분하지 않는다. 컴파일 시 알아서 바꿔준다
    var number4: Long? = 1_000L // null 할당 가능한 reference 타입은 ?을 붙여줘야 한다
    number4 = null
}