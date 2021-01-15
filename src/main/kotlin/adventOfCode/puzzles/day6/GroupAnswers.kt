package adventOfCode.puzzles.day6

typealias GroupAnswers = List<PersonalAnswers>
typealias PersonalAnswers = String

fun countAnswersWithAtLeastOneVote(groupAnswers: GroupAnswers): Int {
    val answersVotedAtLeastOnce = groupAnswers
        .fold(mutableSetOf<Char>()) { answersVotedAtLeastOnce, personalAnswer ->
            answersVotedAtLeastOnce.addAll(personalAnswer.toList())
            answersVotedAtLeastOnce
        }

    return answersVotedAtLeastOnce.size
}

fun countAnswersWhichEveryoneVoted(groupAnswers: GroupAnswers): Int =
    groupAnswers
        .map { it.toSet() }
        .reduce { acc, item -> acc intersect item }
        .count()

