import Foundation

struct ChordBlock: Identifiable, Codable {
    var chordId: Int?
    var projectId: Int?
    
    var orderIndex: Int
    var chordName: String
    
    init(orderIndex: Int, chordName: String) {
        self.orderIndex = orderIndex
        self.chordName = chordName
    }
}
