import Navbar from "../../components/navbar/Navbar";
import { useEffect, useState } from "react";
import axios from "axios";

const GetXML = () => {
    const [roles, setRoles] = useState([]);
    const user = JSON.parse(localStorage.getItem('user'));
    const [selectedFile, setSelectedFile] = useState(null);

    useEffect(() => {
        if (user != null)
            setRoles(user.roles);
    }, []);

    const getJSON = async () => {
        const response = await axios.get("http://localhost:3000/api/anime/getJSON", { headers: { "Content-Type": "application/json", "withCredentials": true } });
        const content = response.data;
        console.log(content);

        const a = document.createElement("a");
        const file = new Blob([JSON.stringify(content)], { type: "application/json" });
        a.href = URL.createObjectURL(file);
        a.download = "data.json";
        a.click();
    }


    const refreshData = async () => {
        const jwt = user.accessToken;
        const headers= {
            'withCredentials': true,
        }
        await axios.get("http://localhost:3000/api/movies/top_api", {headers: headers});
        await axios.get("http://localhost:3000/api/anime/top_api", {headers: headers});
    }
        

    // Funkcja obsługująca wybór pliku
    const handleFileSelect = (event) => {
        setSelectedFile(event.target.files[0]);
    }

  const handleJSONUpload = async () => {
    if (selectedFile) {
        try {
            const jwt = user.accessToken;
            const formData = new FormData();
            formData.append('file', selectedFile);

            await axios.post('http://localhost:3000/api/anime/addJSON', formData, {
            headers: {
                'withCredentials': true,
            },
            });

            console.log('Plik został przesłany.');
        } catch (error) {
            console.error('Wystąpił błąd podczas przesyłania pliku:', error);
        }
    }
    }


    return (
    <div className="flex w-screen h-screen">
        <Navbar/>
        <div className="h-[100%] w-[100%] flex items-center flex-grow bg-[#ffe7cc]">
            <div className="mr-16 overflow-y-auto h-5/6 w-[83.333333%] flex-grow rounded-br-3xl rounded-tr-3xl border-b-2 border-r-2 border-t-2 border-[#fea1a1] bg-[#f9fbe7] flex items-center justify-center">
                <div className="flex  flex-col items-center">
                {roles.includes("ROLE_ADMIN") ? (
                    <div className="flex flex-col space-y-4">
                        <h1 className="text-2xl text-[#fea1a1]  drop-shadow-lg">Get JSON of anime</h1>
                        <button className="w-fit border shadow-md hover:shadow-lg border-[#fea1a1] bg-[#f9fbe7] text-[#fea1a1] mt-2 pt-2 pb-2 pl-6 pr-6 rounded-3xl" onClick={() => getJSON()}>Get anime from DB</button>
                        <br/>
                        <h1 className="text-2xl text-[#fea1a1]  drop-shadow-lg">Upload JSON of anime to populate DB</h1>
                        <div>
                        <button className="mr-4 w-fit border shadow-md hover:shadow-lg border-[#fea1a1] bg-[#f9fbe7] text-[#fea1a1] mt-2 pt-2 pb-2 pl-6 pr-6 rounded-3xl" onClick={handleJSONUpload}>Prześlij</button>
                        <input type="file" accept=".json" className="text-[#fea1a1]  drop-shadow-lg" onChange={handleFileSelect}/>
                        </div>
                        <br/>
                        <h1 className="text-2xl text-[#fea1a1]  drop-shadow-lg">Refresh data in DB from APIs</h1>
                        <button className="w-fit border shadow-md hover:shadow-lg border-[#fea1a1] bg-[#f9fbe7] text-[#fea1a1] mt-2 pt-2 pb-2 pl-6 pr-6 rounded-3xl" onClick={() => refreshData()}>Refresh</button>
                    </div>) : 
                    (
                    <div className="flex flex-col items-center">
                        <p className="text-xl font-bold">Operations not permitted</p>
                    </div>
                    )
                }
                </div>
            </div>
        </div>
    </div>
    );
}


export default GetXML;