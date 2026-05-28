import poundation

struct Project: Identifiable, Codable {
    var projectId : Int?
    var userId: Int?
    
    var projectName: String
    var bpm: Int
    var timeSignature: String
    var scale: String
    var createdAt: Date?
    var updatedAt: Date?
    
    var chords: [ChordBlock]
    
    init(
        projectName: String, bpm: String, timeSignature: String, scale: String, chords: [ChordBlock]=[]
    ) {
        self.projectName = projectName
        self.bpm = bpm
        self.timeSignature = timeSignature
        self.chords = chords
    }
}

