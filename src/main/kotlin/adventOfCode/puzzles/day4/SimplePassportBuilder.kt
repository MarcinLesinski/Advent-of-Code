package adventOfCode.puzzles.day4

import adventOfCode.common.setProperty

class SimplePassportBuilder {

    companion object {
        fun build(bundle: Bundle): SimplePassport {
            var passport = SimplePassport()
            bundle.forEach { passport = addProperty(it.first, it.second, passport) }
            return passport
        }

        private fun addProperty(name: String, value: String, passport: SimplePassport): SimplePassport {


                setProperty(passport, name, value)

//                error("there is no property $name in Passport")


            return passport
        }
    }
}