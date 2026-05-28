import SwiftUI

struct CreateSheetView: View {
    @State private var sheetName: String = ""
    @State private var scale: String = ""
    @State private var bpm: String = ""
    @State private var time: String = ""
    
    let mintColor = Color(red: 166/255, green: 209/255, blue: 185/255)
    
    var body: some View {
        ZStack{
            Color("mojakBackgroud")
                .ignoresSafeArea()
            
            VStack(spacing: 10) {
                VStack(spacing: -10) {
                    Image("mojak_logo2")
                        .resizable()
                        .scaledToFit()
                        .frame(width: 250)
                }
                .padding(.top, 10)
                
                VStack(alignment: .leading, spacing: 15) {
                    inputField(label: "Sheet Name", text: $sheetName)
                    inputField(label: "Scale", text: $scale)
                    inputField(label: "BPM", text: $bpm)
                    inputField(label: "time", text: $time)
                    
                    HStack{
                        Spacer()
                        Button(action:{
                            print("악보 생성 시작")
                        }) {
                            Text("Create")
                                .font(.custom("Pacifico", size: 20))
                                .bold()
                                .foregroundColor(.white)
                                .padding(.horizontal, 40)
                                .padding(.vertical, 8)
                                .background(mintColor)
                                .cornerRadius(30)
                                .shadow(color: .gray.opacity(0.4), radius: 3, x:2, y:2)
                        }
                        Spacer()
                    }
                    .padding(.top, 10)
                }
                .padding(35)
                .background(
                    RoundedRectangle(cornerRadius: 40)
                        .stroke(mintColor, lineWidth: 5)
                        .background(Color.white.opacity(0.3).cornerRadius(40))
                )
                .padding(.horizontal, 25)
                
                Spacer()
            }
        }
        .navigationBarBackButtonHidden(true)
    }
    
    private func inputField(label: String, text: Binding<String>) -> some View {
        VStack(alignment: .leading, spacing: 5) {
            Text(label)
                .font(.custom("Pacifico", size:24))
                .foregroundColor(Color("mojakOrange"))
                .italic()
                .shadow(color: .gray.opacity(0.2), radius:1, x: 1, y: 1)
            
            TextField("", text: text)
                .padding(10)
                .background(Color(red:215/255, green:215/255, blue:215/255).opacity(0.6))
                .cornerRadius(15)
        }
    }
}

#Preview {
    CreateSheetView()
}
