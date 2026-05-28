import SwiftUI

struct StartView: View {
    var body: some View{
        NavigationStack{
            ZStack {
                Color("mojakBackgroud")
                    .ignoresSafeArea()
                
                VStack {
                    Spacer()
                    
                    VStack(spacing: 15) {
                        Image("mojak_logo1")
                            .resizable()
                            .scaledToFit()
                            .frame(width:360)
                            .padding(.top, 60)
                            

                        Spacer()
                        
                        NavigationLink(destination: CreateSheetView()) {
                            Text("press the start button")
                                                        .font(.custom("Pacifico", size: 30))
                                                        .foregroundColor(Color("mojakOrange"))
                                                }
                                                .padding(.bottom, 180)
                        }
                    }
                }
            }
        }
    }

#Preview {
    StartView()
}

