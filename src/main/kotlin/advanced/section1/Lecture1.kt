package advanced.section1

/**
 * 제네릭
 * Cage<Fish> != Cage<GoldFish> -> 무공변(불공변, in-variant), 아무 관계가 없음(상속 관계가 아님)
 * Java문법에서 Object <- String이면 Object[] <- String[] => 공변(co-variant)하다
 *
 * 위험한 코드
 * String[] strs = new String[]{"A", "B"}
 * Object[] objs = sts;
 * objs[0] = 1 -> runtime 에러 발생
 *
 * 리스트의 경우 제네릭을 사용하기 때문에 무공변하여 아래 코드 불가
 * List<String> strs = ...
 * List<Object> objs = strs -> 불가
 *
 * out -> 무공변 -> 공변에 변성을 줌, 변성 애노테이션(variance annotation)
 * out이 붙으면 생산만 가능(put, add등의 메서드 호출 불가)
 * 즉 out이 붙은 제네릭은 T의 자식 타입을 꺼낼 수 있는 형태의 연산만 지원한다는 의미 -> 소비 역할까지 부여하게 되면 타입 안정성이 깨짐
 *
 * in -> 반공변(ContraVariant)
 * 공변관계를 역으로 바꾸면 해당 제니릭은 소비만 가능
 * Fish <- GoldFish => Cage2<GoldFish> <- Cage2<Fish>
 *
 * out : 해당 파라미터는 생산자, 공변
 * in : 해당 파라미터는 소비자, 반공변
 *
 * 클래스 자체에 변성을 줄 수 있다. 이 경우 해당 클래스는 소비자, 생산자 역할만 할 수 있다
 *
 * 클래스에 변성을 준 경우 어쩔 수 생산자가 어쩔 수 없이 데이터를 받아야 하는 경우 @UnsafeVariace 사용
 * 예) list의 contains()메소드
 *
 * 제네릭 제약 -> : 키워드 사용, where 키워드를 이용해 여러 제약조건을 줄 수도 있다
 * non-null generic의 경우 : Any를 사용한다
 *
 * 코틀린은 개발 단계부터 제네릭을 고려했기 때문에 raw type을 사용할 수 없다
 * 하지만 JVM에서 돌아야 하기 때문에 런타입에는 타입소거가 일어난다
 * fun checkStringList<data: Any>{
 *  if(data is List<String>){
 *
 *  }
 *  star projection을 이용해 적어도 리스트 형인지는 알 수 있음
 *  if(data is List<*>){
 *  }
 * }
 * 제네릭은 런타입에 타입을 가져올 수 없다
 *
 * 클래스 내에 제네릭을 동일한 이름으로 선언할 경우 타입 파라미터 쉐도잉이 일어난다
 * 제네릭 클래스도 상속이 가능하다
 */
fun main() {
    val cage = Cage()
    cage.put(Carp("잉어"))
    val carp: Animal = cage.getFirst() // carp타입으로 꺼낼 수 없음
    val carp1: Carp = cage.getFirst() as Carp // compile 에러 없으나 runtime에러 발생 가능
    val carp2: Carp = cage.getFirst() as? Carp ?: throw IllegalStateException()

    val carpCage = GenericCage<Carp>()
    val carp3: Carp = carpCage.getFirst()

    val fishCage = GenericCage<Fish>()
    // fishCage.moveFrom(carpCage) -> 에러 발생
    //

    val carpCage2 = GenericCage2<Carp>()
    val fishCage2 = GenericCage2<Fish>()
    fishCage2.moveFrom(carpCage2)

    val fish: Fish = fishCage2.getFirst() // carp, goldFish다 나올 수 있음
    carpCage2.moveTo(fishCage2)

    // List<Integer> ints = List.of(1,2,3)
    // List<? extends Number> nums = ints;
    // 특정 지점에 변성을 주는 방식
    val fishCage3: GenericCage2<out Fish> = GenericCage2<Carp>()

    val goldFishCage4: GenericCage3<GoldFish> = GenericCage3<GoldFish>()
    //GenericCage3<Fish>는 GenericCage3<GoldFish>의 상위 타입으로 평가된다
    // 해당 클래스는 소비하는 기능을 수행할 수 없다
    // fishCage4.put(Carp)하게 되면 런타입 에러 발생
    val fishCage4: GenericCage3<Fish> = goldFishCage4

    val numbers = listOf(1, 2, 0.5)
    val result = numbers.hasAnyInstanceOf<Int>()

}

// List타입인 것은 확인할 수 있다
fun checkList(data: Any) {
    if (data is List<*>) {
        val element: Any? = data[0]
        // data.add(3) 불가
    }
}

// 인자로 collection이 들어오는 경우에는 제네릭 활용 가능
fun checkCollection(data: Collection<String>) {
    if (data is MutableList<String>) {
        val element = data.add("a")
    }
}

// 제네릭임에도 타입 정보 활용 가능
inline fun <reified T> List<*>.hasAnyInstanceOf(): Boolean {
    return this.any{it is T}
}

// 함수의 T가 클래스의 T를 shadowing한다
class CageShadow<T : Animal>{
    fun <T : Animal> addAnimal(animal: T) {
        //TOODO
    }
}

open class CageV1<T : Animal>{
    fun addAnimal(animal: T) {

    }
}

class CageV2<T : Animal> : CageV1<T>()
class CageV3 : CageV1<Animal>()

class Lecture1 {
}