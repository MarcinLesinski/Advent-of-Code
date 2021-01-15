package adventOfCode.puzzles.day4

class SimplePassport {
    var ecl: String? = null
    var pid: String? = null
    var eyr: String? = null
    var hcl: String? = null
    var byr: String? = null
    var iyr: String? = null
    var cid: String? = null
    var hgt: String? = null

    fun valid(): Boolean {
        val required = arrayOf(ecl, pid, eyr, hcl, byr, iyr, hgt)
        return required.all { it != null }
    }
}

class Passport {
    var ecl: EyeColor? = null
    var pid: PassportId? = null
    var eyr: ExpirationYear? = null
    var hcl: HairColor? = null
    var byr: BirthYear? = null
    var iyr: IssueYear? = null
    var cid: CountryId? = null
    var hgt: Height? = null

    fun valid(): Boolean {
        val required = arrayOf(ecl, pid, eyr, hcl, byr, iyr, hgt)
        val valid = required.all { it != null }
        return valid
    }
}

data class BirthYear(val value: Int){
    init{
        require(value in 1920..2002){
            "wrong value for BirthYear $value"
        }
    }
}

data class IssueYear(val value: Int){
    init{
        require(value in 2010..2020){
            "wrong value for Issue Year $value"
        }
    }
}

data class ExpirationYear(val value: Int){
    init{
        require(value in 2020..2030){
            "wrong value for ExpirationYear $value"
        }
    }
}

data class Height(private val _value: String){
    val value: Int = parseValue(_value)
    val unit: String = parseUnit(_value)

    init{
        require(unit in setOf("cm", "in"))
        when(unit){
            "cm" -> require(value in 150..193)
            "in" -> require(value in 59..76)
        }
    }

    private fun parseValue(text: String): Int{
        return text.dropLast(2).toInt()
    }

    private fun parseUnit(text: String): String{
        return text.takeLast(2)
    }
}

data class HairColor(val value: String){
    private val pattern =  Regex("^#[0-9,a-f]{6}$")

    init{
        require(pattern.matches(value))
    }
}

data class EyeColor(val value: String){
    private val  allowedValues =
        setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")

    init{
        require(value in allowedValues)
    }
}

data class PassportId(val value: String){
    private val pattern = Regex("^[0-9]{9}$")

    init{
        require(pattern.matches(value))
    }
}

data class CountryId(val value: String){

}