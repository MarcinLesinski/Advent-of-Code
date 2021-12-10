package adventOfCode.puzzles.year2020.day4

class PassportBuilder {

    companion object {
        fun build(bundle: Bundle): Passport {
            var passport = Passport()
            bundle.forEach { passport = addProperty(it.first, it.second, passport) }
            return passport
        }


        private fun addProperty(name: String, value: String, passport: Passport): Passport {

            when (name) {
                "ecl" -> {
                    passport.ecl = createIfValid{ EyeColor(value)}
                }
                "pid" -> {
                    passport.pid = createIfValid{ PassportId(value)}
                }
                "eyr" -> {
                    passport.eyr = createIfValid{ ExpirationYear(value.toInt())}
                }
                "hcl" -> {
                    passport.hcl = createIfValid{ HairColor(value)}
                }
                "byr" -> {
                    passport.byr = createIfValid{ BirthYear(value.toInt())}
                }
                "iyr" -> {
                    passport.iyr = createIfValid{ IssueYear(value.toInt())}
                }
                "cid" -> {
                    passport.cid = createIfValid{CountryId(value)}
                }
                "hgt" -> {
                    passport.hgt = createIfValid{Height(value)}
                }
                else -> error("there is no property $name in Passport")
            }
            return passport
        }

        private fun <T> createIfValid(constructionBlock: () -> T): T? {
            return try {
                constructionBlock()
            } catch (e: IllegalArgumentException) {
                null
            }
        }
    }
}
