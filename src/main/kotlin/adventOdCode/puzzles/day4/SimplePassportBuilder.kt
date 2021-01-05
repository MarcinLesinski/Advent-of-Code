package adventOdCode.puzzles.day4

import java.lang.Exception
import java.lang.IllegalArgumentException

class SimplePassportBuilder {

    companion object {
        fun build(bundle: Bundle): SimplePassport {
            var passport = SimplePassport()
            bundle.forEach { passport = addProperty(it.first, it.second, passport) }
            return passport
        }

        //TODO: try use reflection for finding property and  compare benchmark results
        private fun addProperty(name: String, value: String, passport: SimplePassport): SimplePassport {

            when (name) {
                "ecl" -> {
                    passport.ecl = value
                }
                "pid" -> {
                    passport.pid = value
                }
                "eyr" -> {
                    passport.eyr = value
                }
                "hcl" -> {
                    passport.hcl = value
                }
                "byr" -> {
                    passport.byr = value
                }
                "iyr" -> {
                    passport.iyr = value
                }
                "cid" -> {
                    passport.cid = value
                }
                "hgt" -> {
                    passport.hgt = value
                }
                else -> error("there is no property $name in Passport")
            }
            return passport
        }
    }
}