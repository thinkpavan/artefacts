VERSION 5.00
Object = "{67397AA1-7FB1-11D0-B148-00A0C922E820}#6.0#0"; "MSADODC.OCX"
Begin VB.Form frmFineDays 
   BackColor       =   &H00400040&
   Caption         =   "Fine / Days"
   ClientHeight    =   3195
   ClientLeft      =   60
   ClientTop       =   345
   ClientWidth     =   4680
   LinkTopic       =   "Form3"
   Picture         =   "Form3.frx":0000
   ScaleHeight     =   3195
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
   WindowState     =   2  'Maximized
   Begin VB.CommandButton cmdBack 
      BackColor       =   &H00E0E0E0&
      Caption         =   "&Back"
      BeginProperty Font 
         Name            =   "Century Gothic"
         Size            =   15.75
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   7875
      Style           =   1  'Graphical
      TabIndex        =   7
      Top             =   6450
      Width           =   1215
   End
   Begin VB.CommandButton cmdDelete 
      BackColor       =   &H00E0E0E0&
      Caption         =   "&Delete"
      BeginProperty Font 
         Name            =   "Century Gothic"
         Size            =   15.75
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   6285
      Style           =   1  'Graphical
      TabIndex        =   6
      Top             =   6450
      Width           =   1215
   End
   Begin VB.CommandButton cmdSave 
      BackColor       =   &H00E0E0E0&
      Caption         =   "&Save"
      BeginProperty Font 
         Name            =   "Century Gothic"
         Size            =   15.75
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   4635
      Style           =   1  'Graphical
      TabIndex        =   5
      Top             =   6465
      Width           =   1215
   End
   Begin VB.CommandButton cmdAdd 
      BackColor       =   &H00E0E0E0&
      Caption         =   "&Add"
      BeginProperty Font 
         Name            =   "Century Gothic"
         Size            =   15.75
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   3045
      Style           =   1  'Graphical
      TabIndex        =   4
      Top             =   6465
      Width           =   1215
   End
   Begin MSAdodcLib.Adodc Adodc1 
      Height          =   495
      Left            =   5280
      Top             =   2040
      Width           =   2175
      _ExtentX        =   3836
      _ExtentY        =   873
      ConnectMode     =   0
      CursorLocation  =   3
      IsolationLevel  =   -1
      ConnectionTimeout=   15
      CommandTimeout  =   30
      CursorType      =   3
      LockType        =   3
      CommandType     =   2
      CursorOptions   =   0
      CacheSize       =   50
      MaxRecords      =   0
      BOFAction       =   0
      EOFAction       =   0
      ConnectStringType=   1
      Appearance      =   1
      BackColor       =   -2147483643
      ForeColor       =   -2147483640
      Orientation     =   0
      Enabled         =   -1
      Connect         =   "Provider=Microsoft.Jet.OLEDB.4.0;Data Source=C:\WINDOWS\Desktop\nLIB\db1.mdb;Persist Security Info=False"
      OLEDBString     =   "Provider=Microsoft.Jet.OLEDB.4.0;Data Source=C:\WINDOWS\Desktop\nLIB\db1.mdb;Persist Security Info=False"
      OLEDBFile       =   ""
      DataSourceName  =   ""
      OtherAttributes =   ""
      UserName        =   ""
      Password        =   ""
      RecordSource    =   "finedays"
      Caption         =   "Adodc1"
      BeginProperty Font {0BE35203-8F91-11CE-9DE3-00AA004BB851} 
         Name            =   "MS Sans Serif"
         Size            =   8.25
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      _Version        =   393216
   End
   Begin VB.TextBox txtDays 
      BackColor       =   &H80000009&
      DataField       =   "days"
      DataSource      =   "Adodc1"
      BeginProperty Font 
         Name            =   "Century Gothic"
         Size            =   24
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H80000015&
      Height          =   975
      Index           =   1
      Left            =   6360
      MaxLength       =   2
      TabIndex        =   1
      Top             =   4800
      Width           =   2775
   End
   Begin VB.TextBox txtFine 
      BackColor       =   &H80000009&
      DataField       =   "fine"
      DataSource      =   "Adodc1"
      BeginProperty Font 
         Name            =   "Century Gothic"
         Size            =   24
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H80000015&
      Height          =   975
      Index           =   0
      Left            =   6360
      MaxLength       =   4
      TabIndex        =   0
      Top             =   3360
      Width           =   2775
   End
   Begin VB.Label Label1 
      AutoSize        =   -1  'True
      BackStyle       =   0  'Transparent
      Caption         =   "Enter Fine and Days"
      BeginProperty Font 
         Name            =   "Century Gothic"
         Size            =   24
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00C0E0FF&
      Height          =   585
      Left            =   3915
      TabIndex        =   8
      Top             =   2055
      Width           =   4620
   End
   Begin VB.Label Label3 
      BackStyle       =   0  'Transparent
      Caption         =   "Days allowed"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   18
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   975
      Left            =   3345
      TabIndex        =   3
      Top             =   4800
      Width           =   2775
   End
   Begin VB.Label Label2 
      BackStyle       =   0  'Transparent
      Caption         =   "Fine per day (Rs)"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   18
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   975
      Left            =   3345
      TabIndex        =   2
      Top             =   3360
      Width           =   2775
   End
End
Attribute VB_Name = "frmFineDays"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Public con As ADODB.Connection
Public rec2 As ADODB.Recordset


Private Sub Form_Load()
Me.Adodc1.Visible = False
cmdAdd.Enabled = False
cmdSave.Enabled = False

Set con = New ADODB.Connection
con.ConnectionString = " Provider=Microsoft.Jet.OLEDB.4.0;Data Source=C:\WINDOWS\Desktop\nLIB\db1.mdb;Persist Security Info=False "
con.Open
Set rec2 = New ADODB.Recordset
If rec2.State Then rec2.Close

rec2.Open "select fine from finedays", con, adOpenDynamic, adLockOptimistic

If rec2.EOF = True Then
cmdDelete.Enabled = False
cmdAdd.Enabled = True
End If

If rec2.EOF = False Then
txtFine(0).Text = rec2!fine
End If
End Sub

Private Sub cmdAdd_Click()
Me.txtFine(0).SetFocus
cmdAdd.Enabled = False
cmdSave.Enabled = True
Me.Adodc1.Recordset.AddNew
End Sub

Private Sub cmdBack_Click()
Unload Me
frmMain.Show
End Sub

Private Sub cmdDelete_Click()
cmdDelete.Enabled = False
cmdAdd.Enabled = True
Me.Adodc1.Recordset.Delete adAffectCurrent
MsgBox " Record deleted"
End Sub

Private Sub cmdSave_Click()
cmdSave.Enabled = False

If Me.txtDays(1).Text = "" And Me.txtFine(0).Text = "" Then
    MsgBox ("Enter Fine & Days")
    Exit Sub
    Else
    
    If Me.txtDays(1).Text = "" And Me.txtFine(0) <> "" Then
        MsgBox ("Enter No. of Days")
        Exit Sub
        Else
        
        If Me.txtDays(1).Text <> "" And Me.txtFine(0) = "" Then
            MsgBox ("Enter Fine")
            Exit Sub
        End If
    End If
End If
    
Me.Adodc1.Recordset.Update
End Sub


Private Sub txtDays_Change(Index As Integer)
Me.cmdSave.Enabled = True
End Sub

Private Sub txtDays_KeyPress(Index As Integer, KeyAscii As Integer)
Dim STRVALID As String
STRVALID = "0123456789"
KeyAscii = Asc(UCase(Chr(KeyAscii)))
If KeyAscii > 26 Then
    If InStr(STRVALID, Chr(KeyAscii)) = 0 Then
        KeyAscii = 0
    End If
End If
End Sub

Private Sub txtFine_Change(Index As Integer)
Me.cmdSave.Enabled = True
End Sub

Private Sub txtFine_KeyPress(Index As Integer, KeyAscii As Integer)
Dim STRVALID As String
STRVALID = "0123456789."
KeyAscii = Asc(UCase(Chr(KeyAscii)))
If KeyAscii > 26 Then
    If InStr(STRVALID, Chr(KeyAscii)) = 0 Then
        KeyAscii = 0
    End If
End If
If KeyAscii = 13 Then
Me.txtDays(1).SetFocus
End If
End Sub
